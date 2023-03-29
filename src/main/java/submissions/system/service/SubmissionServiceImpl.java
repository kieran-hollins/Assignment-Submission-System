package submissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import submissions.system.model.*;
import submissions.system.repository.StudentRepository;
import submissions.system.repository.SubmissionRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public List<Submission> getAllSubmissions() {
        List<Submission> allSubmissions = submissionRepository.findAll();
        return allSubmissions;
    }

    @Override
    public Submission getSubmissionById(long submissionId) {
        Optional<Submission> submission = submissionRepository.findById(submissionId);
        return submission.get();
    }

    @Override
    public Submission addSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public Submission updateSubmissionById(long submissionId, Submission submission) {
        Optional<Submission> submission1 = submissionRepository.findById(submissionId);

        if (submission1.isPresent()) {
            Submission originalSubmission = submission1.get();

            if (Objects.nonNull(submission.getTitle()) && !"".equalsIgnoreCase(submission.getTitle())) {
                originalSubmission.setTitle(submission.getTitle());
            }

            if (Objects.nonNull(submission.getDescription()) && !"".equalsIgnoreCase(submission.getDescription())) {
                originalSubmission.setDescription(submission.getDescription());
            }

            if (Objects.nonNull(submission.getFile())) {
                originalSubmission.setFile(submission.getFile());
            }

            if(Objects.nonNull(submission.getModuleId())) {
                originalSubmission.setModuleId(submission.getModuleId());
            }

            return submissionRepository.save(originalSubmission);
        }

        return null;
    }

    @Override
    public String deleteSubmissionById(long submissionId) {
        if (submissionRepository.findById(submissionId).isPresent()) {
            submissionRepository.deleteById(submissionId);
            return "Submission deleted sucessfully";
        }
        return "No such submission in database";
    }
}
