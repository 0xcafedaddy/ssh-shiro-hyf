package com.whitehorse.qingzhi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.entity.ManagerLog;
import com.whitehorse.qingzhi.entity.ManagerLogEnum;
import com.whitehorse.qingzhi.result.ResultFactory;
import com.whitehorse.qingzhi.result.ResultInfo;
import com.whitehorse.qingzhi.service.ManagerLecturerService;
import com.whitehorse.qingzhi.service.ManagerService;
import com.whitehorse.qingzhi.service.UserService;

/**
 * @author hyf
 * @date 2017年4月11日
 * @description
 */
@Controller
@RequestMapping(Constants.QINGZHI + "/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ManagerLecturerService managerLecturerService;
	private ResultInfo resultInfo;

	/**
	 * 添加管理员
	 * 
	 * @param manager
	 * @return
	 */
	@RequestMapping(value = Constants.QINGZHI_VERSION + "/addManager", method = RequestMethod.PUT)
	public @ResponseBody ResultInfo putManager(@RequestBody String managerInfo) {
		try {
			int currentTime = (int) (System.currentTimeMillis() / 1000);

			ManagerInfo mManagerInfo = JSON.parseObject(managerInfo, ManagerInfo.class);

			if (mManagerInfo == null) {

				resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);

			} else {
				mManagerInfo.setManagerCreateTime(currentTime);
				mManagerInfo.setManagerUpdateTime(currentTime);
				mManagerInfo.setManagerIsDelete(false);
				int result = managerService.createManagerInfo(mManagerInfo);
				if (result == -1) {

				} else {
					resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, "添加成功");
				}
			}

		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE, null);
		}

		return resultInfo;
	}

	/**
	 * 删除管理员
	 * 
	 * @param account
	 * @return
	 */
	@RequestMapping(value = Constants.QINGZHI_VERSION + "/deleteManager", method = RequestMethod.DELETE)
	public @ResponseBody ResultInfo deleteManager(@RequestBody String account) {

		try {
			String userAccount = JSON.parseObject(account).getString("useraccount");

			if (StringUtils.isEmpty(userAccount)) {// 参数错误

				resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);

			} else {

				int result = managerService.deleteManager(userAccount);

				if (result == 0) {

					resultInfo = ResultFactory.getInstance(Constants.USERNAME_ERRORCODE, null);

				} else {
					resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, "删除成功");
				}
			}
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE, null);
		}

		return resultInfo;
	}

	/**
	 * 为其他管理员添加管理员讲师，默认最多10个
	 * 
	 * @param auth
	 * @return
	 */
	// TODO 讲师管理员是否拥有此权限待定
	@RequestMapping(value = Constants.QINGZHI_VERSION + "/addManagerLecturer", method = RequestMethod.PUT)
	public @ResponseBody ResultInfo addManagerLecturer(@RequestBody String info) {
		try {
			JSONObject jb = JSON.parseObject(info);
			Integer managerId = jb.getInteger("managerId");
			Integer lecturerId = jb.getInteger("lecturerId");
			String lecturerName = jb.getString("lecturerName");
			Integer ip = jb.getInteger("ip");
			if (StringUtils.isEmpty(String.valueOf(managerId)) || StringUtils.isEmpty(String.valueOf(lecturerId))
					|| StringUtils.isEmpty(String.valueOf(ip)) || StringUtils.isEmpty(lecturerName)) {
				resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
			} else {
				int result = managerLecturerService.addLecturer(managerId, lecturerId, lecturerName, ip);

				if (result == 0) {

					resultInfo = ResultFactory.getInstance(Constants.USERNAME_ERRORCODE, null);

				} else if (result == -1) {
					resultInfo = ResultFactory.getInstance(Constants.MANAGER_LECTURER_OUT_CODE, null);

				} else {
					resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, "管理员讲师添加成功");
				}
			}

		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE, null);
		}

		return resultInfo;

	}

	/**
	 * 为其他管理员添加权限
	 * 
	 * @param auth
	 * @return
	 */
	@RequestMapping(value = Constants.QINGZHI_VERSION + "/addManagerAuth", method = RequestMethod.PUT)
	public @ResponseBody ResultInfo addManagerAuth(@RequestBody String auth) {
		try {
			JSONObject jb = JSON.parseObject(auth);
			String useraccount = jb.getString("useraccount");
			String authName = jb.getString("authName");
			String authUrl = jb.getString("authUrl");
			if (StringUtils.isEmpty(useraccount) || StringUtils.isEmpty(authName) || StringUtils.isEmpty(authUrl)) {
				resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
			} else {
				int result = managerService.addAuth(useraccount, authName, authUrl);

				if (result == 0) {
					resultInfo = ResultFactory.getInstance(Constants.USERNAME_ERRORCODE, null);
				} else {
					resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, "权限添加成功");
				}
			}

		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE, null);
		}

		return resultInfo;

	}

	/**
	 * 根据管理员ID，获取其他讲师的管理员
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = Constants.QINGZHI_VERSION + "/findManagerByElseId", method = RequestMethod.GET)
	public @ResponseBody ResultInfo getManagerByElseId(Integer managerId) {
		try {
			if (StringUtils.isEmpty(String.valueOf(managerId))) {
				resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
			} else {
				List<ManagerInfo> managerList = managerService.findManagerByElseId(managerId);

				resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, managerList);
			}

		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE, null);
		}

		return resultInfo;

	}

	/**
	 * 修改讲师的管理员
	 * 
	 * @param managerId
	 * @return
	 */
	@RequestMapping(value = Constants.QINGZHI_VERSION + "/updateByManagerId", method = RequestMethod.POST)
	public @ResponseBody ResultInfo updateManagerLecturer(@RequestBody String data) {
		try {
			JSONObject jb = JSON.parseObject(data);
			Integer managerLecturerId = jb.getInteger("managerLecturerId");
			Integer managerId = jb.getInteger("managerId");

			if (StringUtils.isEmpty(String.valueOf(managerLecturerId))
					|| StringUtils.isEmpty(String.valueOf(managerId))) {

				resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
			} else {
				int result = managerLecturerService.updateManagerLecturerById(managerLecturerId, managerId);
				if (result == 0) {
					resultInfo = ResultFactory.getInstance(Constants.USERNAME_ERRORCODE, null);
				} else {
					resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, "修改成功");
				}

			}
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE, null);
		}

		return resultInfo;

	}
}
