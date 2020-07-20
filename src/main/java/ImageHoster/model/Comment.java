package ImageHoster.model;

import javax.persistence.*;
import java.util.Date;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'comment'. Hence the table named 'comment' will be created in the database with all the columns mapped to all the attributes in 'Comment' class
@Table(name = "comment")
public class Comment {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private Integer id;

    // Text is a Postgres specific column type that allows you to save
    // text based data that will be longer than 256 characters
    @Column(name = "text", length = 256)
    private String text;

    @Column(name = "createdDate")
    private Date createdDate;

    //The 'comment' table is mapped to 'user' table with Many:One mapping
    //Below annotation indicates that the name of the column in 'comment' table referring the primary key in 'users' table will be 'user_id'
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //The 'comment' table is mapped to 'image' table with Many:One mapping
    //Below annotation indicates that the name of the column in 'comment' table referring the primary key in 'image' table will be 'image_id'
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    //empty constructor
    public Comment() {
    }

    //parameterised constructor for the Comment class
    public Comment(Integer id, String text, Date createdDate, User user, Image image) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
        this.user = user;
        this.image = image;
    }

    //getter method for Id
    public Integer getId() {
        return id;
    }

    //setter method for Id
    public void setId(Integer id) {
        this.id = id;
    }

    //getter method for text
    public String getText() {
        return text;
    }

    //setter method for text
    public void setText(String text) {
        this.text = text;
    }

    //getter method for date
    public Date getCreatedDate() {
        return createdDate;
    }

    //setter method for date
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    //getter method for user
    public User getUser() {
        return user;
    }

    //setter method for user
    public void setUser(User user) {
        this.user = user;
    }

    //getter method for image
    public Image getImage() {
        return image;
    }

    //setter method for image
    public void setImage(Image image) {
        this.image = image;
    }
}
