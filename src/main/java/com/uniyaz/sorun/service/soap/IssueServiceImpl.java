package com.uniyaz.sorun.service.soap;

import com.uniyaz.sorun.dao.IssueDao;
import com.uniyaz.sorun.domain.Issue;
import com.uniyaz.sorun.service.converter.IssueConverter;
import com.uniyaz.sorun.service.dto.IssueDto;

import javax.jws.WebService;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/**
 * Created by AKARTAL on 26.12.2019.
 */
@WebServlet(urlPatterns = "/services/*", name = "IssueServiceServlet", loadOnStartup = 1)
@WebListener(value = "com.sun.xml.ws.transport.http.servlet.WSServletContextListener")
@WebService(endpointInterface = "com.uniyaz.sorun.service.soap.IssueService", name = "IssueService")
public class IssueServiceImpl implements IssueService {

    @Override
    public IssueDto saveIssue(IssueDto issueDto) {

        IssueConverter issueConverter = new IssueConverter();
        Issue issue = issueConverter.convertToIssue(issueDto);

        IssueDao issueDao = new IssueDao();
        issue = issueDao.saveIssue(issue);

        IssueDto issueDtoSaved = issueConverter.convertToIssueDto(issue);
        return issueDtoSaved;
    }
}
