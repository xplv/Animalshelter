package at.thurnhaeuser.animalshelter.servicespring;

import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;
import domainmodel.Project;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProjectRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by joachim on 24/02/15.
 */
@Transactional
@Service
public class ProjectService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AnimalRepository animalRepo;

    public Collection<ProjectOverviewDto> findAllProjects() {
        ArrayList<ProjectOverviewDto> projects = new ArrayList<>();
        for (Project project : projectRepository.findAll()) {
            projects.add(ProjectOverviewDto.from(project));
        }
        return projects;
    }

    public ProjectOverviewDto insertProject(ProjectOverviewDto projectOverviewDto) {
        Project project = new Project(projectOverviewDto.getName(), projectOverviewDto.getStartDate(), projectOverviewDto.getEndDate());
        projectRepository.save(project);
        return ProjectOverviewDto.from(project);
    }

    public ProjectOverviewDto findByExternalReference(String externalReference) {
        List<Project> projects = projectRepository.findByExternalReference(externalReference);
        ProjectOverviewDto projectOverviewDto = null;
        for (Project project : projects) {
            projectOverviewDto = ProjectOverviewDto.from(project);
        }
        return projectOverviewDto;
    }

    public static class AnimalOverviewDto {
        @Getter @Setter
        private String externalReference;

        @Getter @Setter
        private String species;

        @Getter @Setter
        private String name;

        @Getter @Setter
        private LocalDate startDate;

        @Getter @Setter
        private LocalDate endDate;

        @Getter @Setter
        private String rootProjectFolderName;

        @Getter @Setter
        private String projectManagerName;

        @Getter @Setter
        private Integer numberOfWorkPackages;

        public static ProjectOverviewDto from(Project project) {
            ProjectOverviewDto dto = new ProjectOverviewDto();
            dto.setExternalReference(project.getExternalReference());
            dto.setName(project.getName());
            dto.setStartDate(project.getStartDate());
            dto.setEndDate(project.getEndDate());
            dto.setRootProjectFolderName((project.getRootProjectFolder() != null)?project.getRootProjectFolder().getName():null);
            dto.setProjectManagerName((project.getProjectManager()!=null)?project.getProjectManager().getName():null);
            dto.setNumberOfWorkPackages(project.getWorkPackages().size());
            return dto;
        }
    }
}
