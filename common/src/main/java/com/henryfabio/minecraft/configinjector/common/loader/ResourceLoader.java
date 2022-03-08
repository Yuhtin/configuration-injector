package com.henryfabio.minecraft.configinjector.common.loader;

import java.io.InputStream;

public abstract class ResourceLoader {

    public abstract InputStream getResource(String fileName);

}
