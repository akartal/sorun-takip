package com.uniyaz.sorun.web.converter;

import com.uniyaz.sorun.domain.Issue;
import com.uniyaz.sorun.web.dto.IssueDto;

/**
 * Created by AKARTAL on 26.12.2019.
 */
public class IssueConverter {

    public Issue convertToIssue(IssueDto issueDto) {

        Issue issue = new Issue();
        issue.setId(issueDto.getId());
        issue.setTopic(issueDto.getTopic());
        issue.setContent(issueDto.getContent());

        // TODO diğer alanlar da çevrilmeli
        return issue;
    }

    public IssueDto convertToIssueDto(Issue issue) {
        IssueDto issueDto = new IssueDto();
        issueDto.setId(issue.getId());
        issueDto.setTopic(issue.getTopic());
        issueDto.setContent(issue.getContent());

        // TODO diğer alanlar da çevrilmeli
        return issueDto;
    }
}