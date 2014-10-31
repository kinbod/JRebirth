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
package org.jrebirth.af.core.resource.image;

import javafx.scene.image.Image;

import org.jrebirth.af.api.resource.builder.ResourceBuilder;
import org.jrebirth.af.api.resource.image.ImageExtension;
import org.jrebirth.af.api.resource.image.ImageItem;
import org.jrebirth.af.api.resource.image.ImageParams;
import org.jrebirth.af.core.resource.ResourceBuilders;

/**
 * The class <strong>ImageItem</strong>.
 *
 * @author Sébastien Bordes
 */
public interface ImageItemReal extends ImageItem {

    /**
     * {@inheritDoc}
     */
    @Override
    default ResourceBuilder<ImageItem, ImageParams, Image> builder() {
        return ResourceBuilders.IMAGE_BUILDER;
    }

    interface Relative extends ImageItemReal {

        /**
         * .
         *
         * @param path the image local path
         * @param name the file name
         * @param extension the image extension
         */
        default void rel(final String path, final String name, final ImageExtension extension) {
            set(new RelImage(path, name, extension));
        }

        /**
         * .
         *
         * @param name the file name
         * @param extension the image extension
         */
        default void rel(final String name, final ImageExtension extension) {
            set(new RelImage(name, extension));
        }

        /**
         * .
         *
         * @param fullName the full file name (including path and image extension)
         */
        default void rel(final String fullName) {
            set(new RelImage(fullName));
        }

    }

    interface Absolute extends ImageItemReal {

        /**
         * .
         *
         * @param path the image local path
         * @param name the file name
         * @param extension the image extension
         */
        default void abs(final String path, final String name, final ImageExtension extension) {
            set(new AbsImage(path, name, extension));
        }

        /**
         * .
         *
         * @param name the file name
         * @param extension the image extension
         */
        default void abs(final String name, final ImageExtension extension) {
            set(new AbsImage(name, extension));
        }

        /**
         * .
         *
         * @param fullName the full file name (including path and image extension)
         */
        default void abs(final String fullName) {
            set(new AbsImage(fullName));
        }

    }

    interface Web extends ImageItemReal {

        /**
         * Default Constructor.
         *
         * @param website the website base url
         * @param path the path of the image to load
         * @param name the image file name to use.
         * @param extension the image extension to use
         */
        default void web(final String website, final String path, final String name, final ImageExtension extension) {
            set(new WebImage(website, path, name, extension));
        }

        /**
         * Default Constructor.
         *
         * @param website the website base url
         * @param secured the http protocol to use (http or https)
         * @param path the path of the image to load
         * @param name the image file name to use.
         * @param extension the image extension to use
         */
        default void web(final String website, final boolean secured, final String path, final String name, final ImageExtension extension) {
            set(new WebImage(website, secured, path, name, extension));
        }
    }

}
