package com.uniyaz.sorun.web.soap;

import com.uniyaz.sorun.web.dto.IssueDto;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by AKARTAL on 26.12.2019.
 */
@WebService
public interface IssueService {

    @WebMethod
    IssueDto saveIssue(IssueDto issueDto);
}
