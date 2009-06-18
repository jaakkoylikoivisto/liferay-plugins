/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.wsrp.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.liferay.wsrp.model.WSRPConsumerPortlet;
import com.liferay.wsrp.service.WSRPConsumerLocalService;
import com.liferay.wsrp.service.WSRPConsumerPortletLocalService;
import com.liferay.wsrp.service.persistence.WSRPConsumerPersistence;
import com.liferay.wsrp.service.persistence.WSRPConsumerPortletPersistence;

import java.util.List;

/**
 * <a href="WSRPConsumerPortletLocalServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class WSRPConsumerPortletLocalServiceBaseImpl
	implements WSRPConsumerPortletLocalService {
	public WSRPConsumerPortlet addWSRPConsumerPortlet(
		WSRPConsumerPortlet wsrpConsumerPortlet) throws SystemException {
		wsrpConsumerPortlet.setNew(true);

		return wsrpConsumerPortletPersistence.update(wsrpConsumerPortlet, false);
	}

	public WSRPConsumerPortlet createWSRPConsumerPortlet(
		long wsrpConsumerPortletId) {
		return wsrpConsumerPortletPersistence.create(wsrpConsumerPortletId);
	}

	public void deleteWSRPConsumerPortlet(long wsrpConsumerPortletId)
		throws PortalException, SystemException {
		wsrpConsumerPortletPersistence.remove(wsrpConsumerPortletId);
	}

	public void deleteWSRPConsumerPortlet(
		WSRPConsumerPortlet wsrpConsumerPortlet)
		throws PortalException, SystemException {
		wsrpConsumerPortletPersistence.remove(wsrpConsumerPortlet);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return wsrpConsumerPortletPersistence.findWithDynamicQuery(dynamicQuery);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
		return wsrpConsumerPortletPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	public WSRPConsumerPortlet getWSRPConsumerPortlet(
		long wsrpConsumerPortletId) throws PortalException, SystemException {
		return wsrpConsumerPortletPersistence.findByPrimaryKey(wsrpConsumerPortletId);
	}

	public List<WSRPConsumerPortlet> getWSRPConsumerPortlets(int start, int end)
		throws SystemException {
		return wsrpConsumerPortletPersistence.findAll(start, end);
	}

	public int getWSRPConsumerPortletsCount() throws SystemException {
		return wsrpConsumerPortletPersistence.countAll();
	}

	public WSRPConsumerPortlet updateWSRPConsumerPortlet(
		WSRPConsumerPortlet wsrpConsumerPortlet) throws SystemException {
		wsrpConsumerPortlet.setNew(false);

		return wsrpConsumerPortletPersistence.update(wsrpConsumerPortlet, true);
	}

	public WSRPConsumerPortlet updateWSRPConsumerPortlet(
		WSRPConsumerPortlet wsrpConsumerPortlet, boolean merge)
		throws SystemException {
		wsrpConsumerPortlet.setNew(false);

		return wsrpConsumerPortletPersistence.update(wsrpConsumerPortlet, merge);
	}

	public WSRPConsumerLocalService getWSRPConsumerLocalService() {
		return wsrpConsumerLocalService;
	}

	public void setWSRPConsumerLocalService(
		WSRPConsumerLocalService wsrpConsumerLocalService) {
		this.wsrpConsumerLocalService = wsrpConsumerLocalService;
	}

	public WSRPConsumerPersistence getWSRPConsumerPersistence() {
		return wsrpConsumerPersistence;
	}

	public void setWSRPConsumerPersistence(
		WSRPConsumerPersistence wsrpConsumerPersistence) {
		this.wsrpConsumerPersistence = wsrpConsumerPersistence;
	}

	public WSRPConsumerPortletLocalService getWSRPConsumerPortletLocalService() {
		return wsrpConsumerPortletLocalService;
	}

	public void setWSRPConsumerPortletLocalService(
		WSRPConsumerPortletLocalService wsrpConsumerPortletLocalService) {
		this.wsrpConsumerPortletLocalService = wsrpConsumerPortletLocalService;
	}

	public WSRPConsumerPortletPersistence getWSRPConsumerPortletPersistence() {
		return wsrpConsumerPortletPersistence;
	}

	public void setWSRPConsumerPortletPersistence(
		WSRPConsumerPortletPersistence wsrpConsumerPortletPersistence) {
		this.wsrpConsumerPortletPersistence = wsrpConsumerPortletPersistence;
	}

	protected void runSQL(String sql) throws SystemException {
		try {
			PortalUtil.runSQL(sql);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(name = "com.liferay.wsrp.service.WSRPConsumerLocalService.impl")
	protected WSRPConsumerLocalService wsrpConsumerLocalService;
	@BeanReference(name = "com.liferay.wsrp.service.persistence.WSRPConsumerPersistence.impl")
	protected WSRPConsumerPersistence wsrpConsumerPersistence;
	@BeanReference(name = "com.liferay.wsrp.service.WSRPConsumerPortletLocalService.impl")
	protected WSRPConsumerPortletLocalService wsrpConsumerPortletLocalService;
	@BeanReference(name = "com.liferay.wsrp.service.persistence.WSRPConsumerPortletPersistence.impl")
	protected WSRPConsumerPortletPersistence wsrpConsumerPortletPersistence;
}