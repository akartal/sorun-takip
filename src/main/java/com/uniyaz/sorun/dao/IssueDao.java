package com.uniyaz.sorun.dao;

import com.uniyaz.sorun.domain.Issue;
import com.uniyaz.sorun.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class IssueDao {

    public Issue saveIssue(Issue issue){

        validateSaveIssue(issue);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();

            issue= (Issue) session.merge(issue);

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return issue;
    }

    private void validateSaveIssue(Issue issue) {
        if (issue.getTopic().trim().equals("")) {
            throw new RuntimeException("Topic boş geçilemez...");
        }
    }

    public List<Issue> findAllIssue() {
        List<Issue> issueList = null;

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            String hql = "Select issue From Issue issue left join fetch issue.category category";
            Query query = session.createQuery(hql);

            issueList = query.list();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return issueList;
    }
}