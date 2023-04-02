package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//import io.micrometer.common.util.StringUtils;
import io.micrometer.core.annotation.Timed;
import submissions.system.model.Submission;
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

    @PostMapping("/submission")
    @Timed
    public Submission submit(@ModelAttribute Submission submission) {
        List<Submission> allSubmissions = submissionRepository.findAll();
        for (Submission submission1 : allSubmissions) {
            if (submission.getId() == submission1.getId()) {
                return submissionService.updateSubmissionById(submission.getId(), submission);
            }
        }
        return submissionService.addSubmission(submission);
    }

    @PostMapping("submission/save")
    public String saveSubmission(@ModelAttribute Submission submission, @RequestParam("file") MultipartFile multiPartFile) throws IOException {
        submission.setFileName(StringUtils.cleanPath(multiPartFile.getOriginalFilename())); 

        submission.setFileData(multiPartFile.getBytes());

        submissionService.addSubmission(submission);


        return "redirect:/success";
    }
}
