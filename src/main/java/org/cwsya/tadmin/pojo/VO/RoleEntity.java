package org.cwsya.tadmin.pojo.VO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author 陈文生
 */
@TableName("role")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 角色唯一标识
	 */
	@TableId
	private Integer id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色状态
	 */
	private Integer status;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updatedTime;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createdTime;

	@Override
	public String toString() {
		return "RoleEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", status=" + status +
				", updatedTime=" + updatedTime +
				", createdTime=" + createdTime +
				'}';
	}

	public RoleEntity() {

	}

	public RoleEntity(Integer id, String name, Integer status, Date updatedTime, Date createdTime) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.updatedTime = updatedTime;
		this.createdTime = createdTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
}
