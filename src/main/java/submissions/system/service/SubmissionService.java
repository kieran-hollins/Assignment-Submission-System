package submissions.system.service;

import java.util.List;

import submissions.system.model.*;

public interface SubmissionService {
    List<Submission> getAllSubmissions();

    Submission addSubmission(Submission submission);

    Submission getSubmissionById(long submissionId);

    Submission updateSubmissionById(long submissionId, Submission submission);

    String deleteSubmissionById(long submissionId);
}
