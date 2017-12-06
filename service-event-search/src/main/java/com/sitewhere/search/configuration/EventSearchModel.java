/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.search.configuration;

import com.sitewhere.configuration.model.AttributeNode;
import com.sitewhere.configuration.model.ElementNode;
import com.sitewhere.configuration.model.ElementRoles;
import com.sitewhere.configuration.model.MicroserviceConfigurationModel;
import com.sitewhere.configuration.old.ISearchProvidersParser;
import com.sitewhere.configuration.old.ITenantConfigurationParser;
import com.sitewhere.spi.microservice.IMicroservice;
import com.sitewhere.spi.microservice.configuration.model.AttributeType;

/**
 * Configuration model for event search microservice.
 * 
 * @author Derek
 */
public class EventSearchModel extends MicroserviceConfigurationModel {

    public EventSearchModel(IMicroservice microservice) {
	super(microservice, null, null, null);
    }

    /*
     * @see com.sitewhere.spi.microservice.configuration.model.IConfigurationModel#
     * getDefaultXmlNamespace()
     */
    @Override
    public String getDefaultXmlNamespace() {
	return "http://sitewhere.io/schema/sitewhere/microservice/event-search";
    }

    /*
     * @see
     * com.sitewhere.configuration.model.MicroserviceConfigurationModel#addElements(
     * )
     */
    @Override
    public void addElements() {
	addElement(createSearchProviders());
	addElement(createSolrSearchProvider());
    }

    /**
     * Create the container for asset management configuration.
     * 
     * @return
     */
    protected ElementNode createSearchProviders() {
	ElementNode.Builder builder = new ElementNode.Builder("Search Providers",
		ITenantConfigurationParser.Elements.SearchProviders.getLocalName(), "search",
		ElementRoles.SearchProviders);
	builder.description("Configure search providers.");
	return builder.build();
    }

    /**
     * Create element configuration for Solr search provider.
     * 
     * @return
     */
    protected ElementNode createSolrSearchProvider() {
	ElementNode.Builder builder = new ElementNode.Builder("Solr Search Provider",
		ISearchProvidersParser.Elements.SolrSearchProvider.getLocalName(), "search",
		ElementRoles.SearchProviders_SearchProvider);

	builder.description("Provider that delegates search tasks to a linked Solr instance.");
	builder.attribute((new AttributeNode.Builder("Id", "id", AttributeType.String)
		.description("Unique id for search provider.").defaultValue("solr").makeIndex().build()));
	builder.attribute((new AttributeNode.Builder("Name", "name", AttributeType.String)
		.description("Name shown for search provider.").defaultValue(" Apache Solr").build()));

	return builder.build();
    }
}