package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import io.micrometer.common.util.StringUtils;
import io.micrometer.core.annotation.Timed;
import submissions.system.model.Submission;
import submissions.system.model.Upload;
import submissions.system.repository.SubmissionRepository;
import submissions.system.service.SubmissionService;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@Controller
public class SubmissionController {
    @Autowired
    SubmissionService submissionService;

    @Autowired
    SubmissionRepository submissionRepository;

    // @PostMapping("/submission")
    // @Timed
    // public Submission submit(@ModelAttribute Submission submission) {
    //     List<Submission> allSubmissions = submissionRepository.findAll();
    //     for (Submission submission1 : allSubmissions) {
    //         if (submission.getId() == submission1.getId()) {
    //             return submissionService.updateSubmissionById(submission.getId(), submission);
    //         }
    //     }
    //     return submissionService.addSubmission(submission);
    // }

    @PostMapping("submission/save")
    public String saveSubmission(@ModelAttribute Upload upload, @RequestParam("file") MultipartFile file) throws IOException {
        Submission submission = new Submission();
        submission.setTitle(upload.getTitle());
        submission.setDescription(upload.getDescription());
        submission.setModuleId(upload.getModuleId());
        submission.setMatNum(upload.getMatNum());

        if (file != null) {
            submission.setFileName(StringUtils.cleanPath(file.getOriginalFilename()));
            submission.setFileData(file.getBytes());
        }
        
        submissionService.addSubmission(submission);

        String view = "redirect:/success/" + submission.getId();
        return view;
    }

    @GetMapping("/success/{id}")
    public ModelAndView submissionSuccess(@PathVariable Long id) {
        
        ModelAndView mav = new ModelAndView("success");
        mav.addObject("submission", submissionRepository.getReferenceById(id));
        return mav;
    }

}
