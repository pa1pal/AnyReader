package pa1pal.anyreader.model;

/**
 * User: pa1pal
 * Date: 10/22/16
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class News implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("photo")
    private String photo;
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("aspect_ratio")
    private Double aspectRatio;
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;
    @SerializedName("published_date")
    private String publishedDate;
    @SerializedName("body")
    private String body;

    protected News(Parcel in) {
        id = in.readString();
        photo = in.readString();
        thumb = in.readString();
        author = in.readString();
        title = in.readString();
        publishedDate = in.readString();
        body = in.readString();
    }

//    public static final Creator<News> CREATOR = new Creator<News>() {
//        @Override
//        public News createFromParcel(Parcel in) {
//            return new News(in);
//        }
//
//        @Override
//        public News[] newArray(int size) {
//            return new News[size];
//        }
//    };

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     * The photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     *
     * @return
     * The thumb
     */
    public String getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb
     * The thumb
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /**
     *
     * @return
     * The aspectRatio
     */
    public Double getAspectRatio() {
        return aspectRatio;
    }

    /**
     *
     * @param aspectRatio
     * The aspect_ratio
     */
    public void setAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     *
     * @return
     * The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The publishedDate
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     *
     * @param publishedDate
     * The published_date
     */
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     *
     * @return
     * The body
     */
    public String getBody() {
        return body;
    }

    /**
     *
     * @param body
     * The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(photo);
        parcel.writeString(thumb);
        parcel.writeDouble(aspectRatio);
        parcel.writeString(author);
        parcel.writeString(title);
        parcel.writeString(publishedDate);
        parcel.writeString(body);
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>()
    {
        public News createFromParcel(Parcel in)
        {
            return new News(in);
        }
        public News[] newArray(int size)
        {
            return new News[size];
        }
    };

}