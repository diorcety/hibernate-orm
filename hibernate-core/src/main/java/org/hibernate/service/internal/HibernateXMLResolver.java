/**
 * com.usharesoft.db.utils.HibernateXMLResolver.java
 *
 * Copyright (c) 2007-2014 UShareSoft SAS, All rights reserved
 * @author UShareSoft
 */
package org.hibernate.service.internal;

import org.hibernate.internal.util.xml.XMLHelper;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class HibernateXMLResolver implements XMLResolver {

    @Override
    public Object resolveEntity(String publicID, String systemID, String baseURI, String namespace) throws XMLStreamException {
        try {
            InputSource inputSource = XMLHelper.DEFAULT_DTD_RESOLVER.resolveEntity(publicID, systemID);
            if (inputSource != null) {
                return inputSource.getByteStream();
            }
            return null;
        } catch (SAXException e) {
            throw new XMLStreamException(e);
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }
}
