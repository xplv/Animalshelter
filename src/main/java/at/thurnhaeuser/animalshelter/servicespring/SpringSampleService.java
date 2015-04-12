package at.thurnhaeuser.animalshelter.servicespring;

import domainmodel.ProjectFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProjectFolderRepository;

/**
 * Created by joachim on 06/11/14.
 */
@Transactional
@Service
public class SpringSampleService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectFolderRepository projectFolderRepository;

    public void useCaseCreate(String folderName) {
        ProjectFolder projectFolder = new ProjectFolder(folderName);
        projectFolderRepository.save(projectFolder);
    }

    public void useCaseA() {
        logger.info("Executing use case A");
        try {
            ProjectFolder projectFolder = new ProjectFolder("Hugo");
            projectFolderRepository.save(projectFolder);
            Long id = projectFolder.getId();

            ProjectFolder pf2 = projectFolderRepository.findOne(id);
            pf2.renameFolder("Quaxi");
            projectFolderRepository.save(pf2);
        } catch (Exception e) {
            logger.error("Failed at Use Case A with: " + e.toString(), e);
            throw new RuntimeException("Failed to execute Use Case A", e);
        }
    }
}
