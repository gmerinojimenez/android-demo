package com.domain.user;


import com.google.gson.annotations.Expose;

import java.util.Comparator;

public class User {

    @Expose
    private String gender;
    @Expose
    private Name name;
    @Expose
    private Location location;
    @Expose
    private String email;
    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String salt;
    @Expose
    private String md5;
    @Expose
    private String sha1;
    @Expose
    private String sha256;
    @Expose
    private String registered;
    @Expose
    private String dob;
    @Expose
    private String phone;
    @Expose
    private String cell;
    @Expose
    private String NINO;
    @Expose
    private Picture picture;
    @Expose
    private String version;
    @Expose
    private String nationality;

    /**
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public User withGender(String gender) {
        this.gender = gender;
        return this;
    }

    /**
     * @return The name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    public User withName(Name name) {
        this.name = name;
        return this;
    }

    /**
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    public User withLocation(Location location) {
        this.location = location;
        return this;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public User withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * @return The salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt The salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User withSalt(String salt) {
        this.salt = salt;
        return this;
    }

    /**
     * @return The md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * @param md5 The md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public User withMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    /**
     * @return The sha1
     */
    public String getSha1() {
        return sha1;
    }

    /**
     * @param sha1 The sha1
     */
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public User withSha1(String sha1) {
        this.sha1 = sha1;
        return this;
    }

    /**
     * @return The sha256
     */
    public String getSha256() {
        return sha256;
    }

    /**
     * @param sha256 The sha256
     */
    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public User withSha256(String sha256) {
        this.sha256 = sha256;
        return this;
    }

    /**
     * @return The registered
     */
    public String getRegistered() {
        return registered;
    }

    /**
     * @param registered The registered
     */
    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public User withRegistered(String registered) {
        this.registered = registered;
        return this;
    }

    /**
     * @return The dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob The dob
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    public User withDob(String dob) {
        this.dob = dob;
        return this;
    }

    /**
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * @return The cell
     */
    public String getCell() {
        return cell;
    }

    /**
     * @param cell The cell
     */
    public void setCell(String cell) {
        this.cell = cell;
    }

    public User withCell(String cell) {
        this.cell = cell;
        return this;
    }

    /**
     * @return The NINO
     */
    public String getNINO() {
        return NINO;
    }

    /**
     * @param NINO The NINO
     */
    public void setNINO(String NINO) {
        this.NINO = NINO;
    }

    public User withNINO(String NINO) {
        this.NINO = NINO;
        return this;
    }

    /**
     * @return The picture
     */
    public Picture getPicture() {
        return picture;
    }

    /**
     * @param picture The picture
     */
    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public User withPicture(Picture picture) {
        this.picture = picture;
        return this;
    }

    /**
     * @return The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public User withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * @return The nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality The nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public User withNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    static class UserComparator implements Comparator<User> {

        @Override
        public int compare(User lhs, User rhs) {
            return lhs.getName().getFirst().compareTo(rhs.getName().getFirst());
        }
    }

}
