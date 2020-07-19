package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    /**
     * Upload a comment data
     * @param comment comment on the pic
     */
    public void createComment(Comment comment) {
        repository.addComment(comment);
    }

    public List<Comment> fetCommentsByImageId(Image image) {
        return repository.getCommentsByImageId(image);
    }
}
