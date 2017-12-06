/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.schedule.configuration;

import com.sitewhere.configuration.model.MicroserviceConfigurationModel;
import com.sitewhere.spi.microservice.IMicroservice;

/**
 * Configuration model for schedule management microservice.
 * 
 * @author Derek
 */
public class ScheduleManagementModel extends MicroserviceConfigurationModel {

    public ScheduleManagementModel(IMicroservice microservice) {
	super(microservice, null, null, null);
    }

    /*
     * @see com.sitewhere.spi.microservice.configuration.model.IConfigurationModel#
     * getDefaultXmlNamespace()
     */
    @Override
    public String getDefaultXmlNamespace() {
	return "http://sitewhere.io/schema/sitewhere/microservice/schedule-management";
    }

    /*
     * @see
     * com.sitewhere.configuration.model.MicroserviceConfigurationModel#addElements(
     * )
     */
    @Override
    public void addElements() {
    }
}