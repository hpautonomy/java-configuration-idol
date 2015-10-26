/*
 * Copyright 2013-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.configuration;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.services.AciService;
import com.autonomy.nonaci.indexing.IndexingService;

public class DistributedConfigValidator implements Validator<DistributedConfig> {

    private AciService aciService;
    private IndexingService indexingService;
    private IdolAnnotationsProcessorFactory processorFactory;

    public void setAciService(final AciService aciService) {
        this.aciService = aciService;
    }

    public void setIndexingService(final IndexingService indexingService) {
        this.indexingService = indexingService;
    }

    public void setProcessorFactory(final IdolAnnotationsProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    @Override
    public ValidationResult<?> validate(final DistributedConfig config) {
        return config.validate(aciService, indexingService, processorFactory);
    }

    @Override
    public Class<DistributedConfig> getSupportedClass() {
        return DistributedConfig.class;
    }
}
