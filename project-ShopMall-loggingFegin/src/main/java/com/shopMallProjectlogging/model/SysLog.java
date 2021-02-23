package com.shopMallProjectlogging.model;

public class SysLog {
	/** 日志ID */
	private String logId;
	/** 员工号 */
	private String empNo;
	/** 操作类型 */
	private String operationType;
	/** 日志标题 */
	private String description;
	/** 请求地址 */
	private String requestUri;
	/** 请求类型 */
	private String requestType;
	/** 类名 */
	private String className;
	/** 方法名 */
	private String methodName;
	/** 请求参数 */
	private String params;
	/** 请求发起IP */
	private String requestIp;
	/** 请求响应IP */
	private String responseIp;
	/** 开始时间 */
	private String startTime;
	/** 结束时间 */
	private String endTime;
	/**
	 * 异常码
	 */
	private String exceptionCode;
	/**
	 * 异常信息
	 */
	private String exceptionMessage;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId == null ? null : logId.trim();
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo == null ? null : empNo.trim();
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType == null ? null : operationType.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri == null ? null : requestUri.trim();
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType == null ? null : requestType.trim();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName == null ? null : methodName.trim();
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params == null ? null : params.trim();
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp == null ? null : requestIp.trim();
	}
	
	public String getResponseIp() {
		return responseIp;
	}

	public void setResponseIp(String responseIp) {
		this.responseIp = responseIp == null ? null : responseIp.trim();
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	@Override
	public String toString() {
		return "SysLog [logId=" + logId + ", empNo=" + empNo + ", operationType=" + operationType + ", description="
				+ description + ", requestUri=" + requestUri + ", requestType=" + requestType + ", className="
				+ className + ", methodName=" + methodName + ", params=" + params + ", requestIp=" + requestIp
				+ ", responseIp=" + responseIp + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
