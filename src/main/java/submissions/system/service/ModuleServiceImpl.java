package submissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import submissions.system.model.Module;
import submissions.system.repository.ModuleRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    ModuleRepository moduleRepository;

    @Override
    public List<Module> getAllModules() {
        List<Module> allModules = moduleRepository.findAll();
        return allModules;
    }

    @Override
    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public Module getModuleById(long id) {
        Optional<Module> module = moduleRepository.findById(id);
        return module.get();
    }

    @Override
    public Module updateModuleById(long id, Module module) {
        Optional<Module> module1 = moduleRepository.findById(id);

        if (module1.isPresent()) {
            Module originalModule = module1.get();

            if (Objects.nonNull(module.getModuleName()) && !"".equalsIgnoreCase(module.getModuleName())) {
                originalModule.setModuleName(module.getModuleName());
            }

            if (Objects.nonNull(module.getCredits())) {
                originalModule.setCredits(module.getCredits());
            }

            if (Objects.nonNull(module.getCourseId())) {
                originalModule.setCourseId(module.getCourseId());
            }

            return moduleRepository.save(originalModule);
        }
        return null;
    }

    @Override
    public List<Module> getModulesByCourseId(long courseId) {
        return moduleRepository.getModulesByCourseId(courseId);
    }

    @Override
    public String deleteModuleById(long id) {
        if (moduleRepository.findById(id).isPresent()) {
            moduleRepository.deleteById(id);
            return "Module deleted sucessfully";
        }
        return "No such module in database";
    }

}
