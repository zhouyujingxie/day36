package com.qf.entity;

import java.math.BigDecimal;
import java.util.Date;

/*
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(20) NOT NULL,
  `public_date` datetime DEFAULT NULL,
  `publisher` varchar(50) DEFAULT NULL,
  `isbn` varchar(15) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `picture` varchar(50) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
 */
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Date publicDate;
    private String publisher;
    private String isbn;
    private BigDecimal price;
    private String picture;
    private Integer cid;

    public Book() {
    }

    public Book(Integer id, String title, String author, Date publicDate, String publisher, String isbn, BigDecimal price, String picture, Integer cid) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicDate = publicDate;
        this.publisher = publisher;
        this.isbn = isbn;
        this.price = price;
        this.picture = picture;
        this.cid = cid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicDate=" + publicDate +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", cid=" + cid +
                '}';
    }
}
