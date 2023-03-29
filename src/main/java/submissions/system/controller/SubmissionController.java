package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import io.micrometer.core.annotation.Timed;
import submissions.system.model.Submission;
import submissions.system.repository.SubmissionRepository;
import submissions.system.service.SubmissionService;

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
}
