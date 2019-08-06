package com.wickvood.albumsearch.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Comparator;


public class AlbumsModel implements Parcelable {

    @SerializedName("wrapperType")
    @Expose
    private String wrapperType;
    @SerializedName("collectionType")
    @Expose
    private String collectionType;
    @SerializedName("artistId")
    @Expose
    private Integer artistId;
    @SerializedName("collectionId")
    @Expose
    private Integer collectionId;
    @SerializedName("amgArtistId")
    @Expose
    private Integer amgArtistId;
    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("collectionName")
    @Expose
    private String collectionName;
    @SerializedName("collectionCensoredName")
    @Expose
    private String collectionCensoredName;
    @SerializedName("artistViewUrl")
    @Expose
    private String artistViewUrl;
    @SerializedName("collectionViewUrl")
    @Expose
    private String collectionViewUrl;
    @SerializedName("artworkUrl60")
    @Expose
    private String artworkUrl60;
    @SerializedName("artworkUrl100")
    @Expose
    private String artworkUrl100;
    @SerializedName("collectionPrice")
    @Expose
    private Double collectionPrice;
    @SerializedName("collectionExplicitness")
    @Expose
    private String collectionExplicitness;
    @SerializedName("trackCount")
    @Expose
    private Integer trackCount;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("primaryGenreName")
    @Expose
    private String primaryGenreName;
    @SerializedName("contentAdvisoryRating")
    @Expose
    private String contentAdvisoryRating;

    protected AlbumsModel(Parcel in) {
        wrapperType = in.readString();
        collectionType = in.readString();
        if (in.readByte() == 0) {
            artistId = null;
        } else {
            artistId = in.readInt();
        }
        if (in.readByte() == 0) {
            collectionId = null;
        } else {
            collectionId = in.readInt();
        }
        if (in.readByte() == 0) {
            amgArtistId = null;
        } else {
            amgArtistId = in.readInt();
        }
        artistName = in.readString();
        collectionName = in.readString();
        collectionCensoredName = in.readString();
        artistViewUrl = in.readString();
        collectionViewUrl = in.readString();
        artworkUrl60 = in.readString();
        artworkUrl100 = in.readString();
        if (in.readByte() == 0) {
            collectionPrice = null;
        } else {
            collectionPrice = in.readDouble();
        }
        collectionExplicitness = in.readString();
        if (in.readByte() == 0) {
            trackCount = null;
        } else {
            trackCount = in.readInt();
        }
        copyright = in.readString();
        country = in.readString();
        currency = in.readString();
        releaseDate = in.readString();
        primaryGenreName = in.readString();
        contentAdvisoryRating = in.readString();
    }

    public static final Creator<AlbumsModel> CREATOR = new Creator<AlbumsModel>() {
        @Override
        public AlbumsModel createFromParcel(Parcel in) {
            return new AlbumsModel(in);
        }

        @Override
        public AlbumsModel[] newArray(int size) {
            return new AlbumsModel[size];
        }
    };

    public static final Comparator<AlbumsModel> BY_NAME_ALPHABETICAL = new Comparator<AlbumsModel>() {
        @Override
        public int compare(AlbumsModel album, AlbumsModel t1) {

            return album.collectionName.compareTo(t1.collectionName);
        }
    };

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getAmgArtistId() {
        return amgArtistId;
    }

    public void setAmgArtistId(Integer amgArtistId) {
        this.amgArtistId = amgArtistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public Double getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(Double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(wrapperType);
        dest.writeString(collectionType);
        if (artistId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(artistId);
        }
        if (collectionId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(collectionId);
        }
        if (amgArtistId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(amgArtistId);
        }
        dest.writeString(artistName);
        dest.writeString(collectionName);
        dest.writeString(collectionCensoredName);
        dest.writeString(artistViewUrl);
        dest.writeString(collectionViewUrl);
        dest.writeString(artworkUrl60);
        dest.writeString(artworkUrl100);
        if (collectionPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(collectionPrice);
        }
        dest.writeString(collectionExplicitness);
        if (trackCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trackCount);
        }
        dest.writeString(copyright);
        dest.writeString(country);
        dest.writeString(currency);
        dest.writeString(releaseDate);
        dest.writeString(primaryGenreName);
        dest.writeString(contentAdvisoryRating);
    }
}