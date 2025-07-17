package controller;

import model.Feedback;
import com.database.FeedbackDAO;

import java.util.List;

public class FeedbackController {

    private FeedbackDAO dao;

    public FeedbackController() {
        dao = new FeedbackDAO();
    }

    public boolean submitFeedback(Feedback fb) {
        return dao.insertFeedback(fb);
    }

    public List<Feedback> getAllFeedback() {
        return dao.getAllFeedback();
    }

    public boolean updateFeedback(Feedback fb) {
        return dao.updateFeedback(fb);
    }

    public boolean deleteFeedback(int id) {
        return dao.deleteFeedback(id);
    }
}
