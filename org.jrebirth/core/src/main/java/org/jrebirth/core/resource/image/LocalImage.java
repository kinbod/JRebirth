/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2013
 * Contact : sebastien.bordes@jrebirth.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jrebirth.core.resource.image;

/**
 * The interface <strong>LocalImage</strong>.
 * 
 * @author Sébastien Bordes
 */
public class LocalImage extends AbstractBaseImage implements ImageParams {

    /**
     * Default Constructor.
     * 
     * @param path the image local path
     * @param name the file name
     * @param extension the image extension
     */
    public LocalImage(final String path, String name, ImageExtension extension) {
        super(path, name, extension);
    }

    /**
     * Default Constructor.
     * 
     * @param path the image local path
     */
    public LocalImage(String name, ImageExtension extension) {
        this("", name, extension);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(path()).append(PARAMETER_SEPARATOR);
        sb.append(name()).append(PARAMETER_SEPARATOR);
        sb.append(extension());

        return sb.toString();
    }

    /**
     * .
     * 
     * @param localPath
     * @return
     */
    public static LocalImage parseImage(final String serializedImage) {

        String[] parameters = serializedImage.split(PARAMETER_SEPARATOR);

        return new LocalImage(parameters[0], parameters[1], ImageExtension.valueOf(ImageExtension.class, parameters[2]));
    }
}
