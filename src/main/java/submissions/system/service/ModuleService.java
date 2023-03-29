package submissions.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import submissions.system.model.Module;


public interface ModuleService {
    List<Module> getAllModules();

    Module createModule(Module module);

    Module getModuleById(long id);

    Module updateModuleById(long id, Module module);

    String deleteModuleById(long id);

    List<Module> getModulesByCourseId(long courseId);

}
