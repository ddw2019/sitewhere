/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rdb.entities;

import com.sitewhere.spi.area.IArea;
import com.sitewhere.spi.common.ILocation;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "area")
public class Area implements IArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /** Area type id */
    private UUID areaTypeId;

    /** Parent area id */
    private UUID parentId;

    /** Area name */
    private String name;

    /** Area description */
    private String description;

    /** Background color */
    private String backgroundColor;

    /** Foreground color */
    private String foregroundColor;

    /** Border color */
    private String borderColor;

    /** Image URL */
    private String imageUrl;

    /** Icon */
    private String icon;

    /** Unique token */
    private String token;

    /** Date entity was created */
    private Date createdDate;

    /** Username for creator */
    private String createdBy;

    /** Date entity was last updated */
    private Date updatedDate;

    /** Username that updated entity */
    private String updatedBy;

    @ElementCollection
    @CollectionTable(name="area_metadata")
    @MapKeyColumn(name="propKey")
    @Column(name="propValue")
    private Map<String, String> metadata = new HashMap<>();

    @OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.LAZY)
    private List<Location> bounds = new ArrayList<>();

    @Override
    public UUID getAreaTypeId() {
        return areaTypeId;
    }

    @Override
    public List<? extends ILocation> getBounds() {
        return bounds;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getForegroundColor() {
        return foregroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public Date getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public UUID getParentId() {
        return parentId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAreaTypeId(UUID areaTypeId) {
        this.areaTypeId = areaTypeId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public void setBounds(List<Location> bounds) {
        this.bounds = bounds;
    }

}