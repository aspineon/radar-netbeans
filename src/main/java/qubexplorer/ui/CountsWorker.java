package qubexplorer.ui;

import java.io.IOException;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.netbeans.api.project.Project;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;
import org.openide.windows.WindowManager;
import qubexplorer.Counting;
import qubexplorer.IssueFilter;
import qubexplorer.NoSuchProjectException;
import qubexplorer.SonarQube;
import qubexplorer.ui.options.SonarQubeOptionsPanel;

/**
 *
 * @author Victor
 */
class CountsWorker extends SonarQubeWorker<Counting, Void> {
    private ProgressHandle handle;
    private Project project;
    private IssueFilter[] filters;
    private boolean triggerActionPlans;

    public CountsWorker(Project project, String url, String resource, IssueFilter... filters) {
        super(url, resource);
        this.project = project;
        this.filters=filters;
        init();
    }

    public void setTriggerActionPlans(boolean triggerActionPlans) {
        this.triggerActionPlans = triggerActionPlans;
    }
    
    @Override
    protected Counting doInBackground() throws Exception {
        return new SonarQube(getServerUrl()).getCounting(getAuthentication(), getResourceKey(), filters);
    }

    private void init() {
        handle = ProgressHandleFactory.createHandle("Sonar");
        handle.start();
        handle.switchToIndeterminate();
    }

    @Override
    protected void success(Counting counting) {
        SonarMainTopComponent infoTopComponent = (SonarMainTopComponent) WindowManager.getDefault().findTopComponent("InfoTopComponent");
        infoTopComponent.setProject(project);
        infoTopComponent.setCounting(counting);
        infoTopComponent.setSonarQubeUrl(getServerUrl());
        infoTopComponent.setResourceKey(getResourceKey());
        infoTopComponent.open();
        infoTopComponent.requestVisible();
    }

    @Override
    protected void finished() {
        try {
            handle.finish();
            if(triggerActionPlans) {
                ActionPlansWorker workerPlans = new ActionPlansWorker(NbPreferences.forModule(SonarQubeOptionsPanel.class).get("address", "http://localhost:9000"), SonarQube.toResource(project));
                workerPlans.execute();
            }
        } catch (IOException | XmlPullParserException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    protected SonarQubeWorker createCopy() {
        return new CountsWorker(project, getServerUrl(), getResourceKey());
    }

    @Override
    protected void error(Throwable cause) {
        if(cause instanceof NoSuchProjectException) {
            if(getAuthentication() != null) {
                AuthenticationRepository.getInstance().saveAuthentication(getServerUrl(), null, getAuthentication());
            }
            ProjectChooser chooser=new ProjectChooser(WindowManager.getDefault().getMainWindow(), true);
            chooser.setSelectedUrl(getServerUrl());
            chooser.setServerUrlEnabled(false);
            chooser.loadProjectKeys();
            if(chooser.showDialog() == ProjectChooser.Option.ACCEPT) {
                scheduleWorker(new CountsWorker(project, getServerUrl(), chooser.getSelectedProjectKey()));
            }
        }else{
            super.error(cause);
        }
    }
    
}
