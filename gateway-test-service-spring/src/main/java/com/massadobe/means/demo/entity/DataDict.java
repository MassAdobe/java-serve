package com.massadobe.means.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "data_dict")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataDict {
    /**
     * 字典id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dict_id")
    private Long dictId;

    /**
     * 字典值
     */
    @Column(name = "map_val")
    private String mapVal;

    /**
     * 字典编号
     */
    @Column(name = "map_code")
    private String mapCode;

    /**
     * 字典名称
     */
    @Column(name = "dict_name")
    private String dictName;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    private String dictType;

    /**
     * 是否煤矿(1煤矿；2非煤矿)
     */
    @Column(name = "is_coal")
    private Byte isCoal;

    /**
     * 初训学时
     */
    @Column(name = "initial_hour")
    private BigDecimal initialHour;

    /**
     * 复训学时
     */
    @Column(name = "retrain_hour")
    private BigDecimal retrainHour;

    /**
     * 排序
     */
    @Column(name = "dict_sort")
    private Integer dictSort;

    /**
     * 上级编号
     */
    @Column(name = "super_id")
    private Long superId;

    /**
     * 备注
     */
    @Column(name = "dict_remark")
    private String dictRemark;

    /**
     * 层级
     */
    @Column(name = "dict_level")
    private Integer dictLevel;

    /**
     * 创建时间
     */
    @Column(name = "created_tm")
    private Date createdTm;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 修改时间
     */
    @Column(name = "updated_tm")
    private Date updatedTm;

    /**
     * 修改人
     */
    @Column(name = "updated_by")
    private Long updatedBy;

    /**
     * 是否有效：1.有效；2.无效
     */
    @Column(name = "is_enabled")
    private Byte isEnabled;

    /**
     * 是否删除：1.未删除；2.已删除
     */
    @Column(name = "is_deleted")
    private Byte isDeleted;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字典id
     *
     * @return dict_id - 字典id
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     * 设置字典id
     *
     * @param dictId 字典id
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    /**
     * 获取字典值
     *
     * @return map_val - 字典值
     */
    public String getMapVal() {
        return mapVal;
    }

    /**
     * 设置字典值
     *
     * @param mapVal 字典值
     */
    public void setMapVal(String mapVal) {
        this.mapVal = mapVal;
    }

    /**
     * 获取字典编号
     *
     * @return map_code - 字典编号
     */
    public String getMapCode() {
        return mapCode;
    }

    /**
     * 设置字典编号
     *
     * @param mapCode 字典编号
     */
    public void setMapCode(String mapCode) {
        this.mapCode = mapCode;
    }

    /**
     * 获取字典名称
     *
     * @return dict_name - 字典名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 设置字典名称
     *
     * @param dictName 字典名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * 获取字典类型
     *
     * @return dict_type - 字典类型
     */
    public String getDictType() {
        return dictType;
    }

    /**
     * 设置字典类型
     *
     * @param dictType 字典类型
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    /**
     * 获取是否煤矿(1煤矿；2非煤矿)
     *
     * @return is_coal - 是否煤矿(1煤矿；2非煤矿)
     */
    public Byte getIsCoal() {
        return isCoal;
    }

    /**
     * 设置是否煤矿(1煤矿；2非煤矿)
     *
     * @param isCoal 是否煤矿(1煤矿；2非煤矿)
     */
    public void setIsCoal(Byte isCoal) {
        this.isCoal = isCoal;
    }

    /**
     * 获取初训学时
     *
     * @return initial_hour - 初训学时
     */
    public BigDecimal getInitialHour() {
        return initialHour;
    }

    /**
     * 设置初训学时
     *
     * @param initialHour 初训学时
     */
    public void setInitialHour(BigDecimal initialHour) {
        this.initialHour = initialHour;
    }

    /**
     * 获取复训学时
     *
     * @return retrain_hour - 复训学时
     */
    public BigDecimal getRetrainHour() {
        return retrainHour;
    }

    /**
     * 设置复训学时
     *
     * @param retrainHour 复训学时
     */
    public void setRetrainHour(BigDecimal retrainHour) {
        this.retrainHour = retrainHour;
    }

    /**
     * 获取排序
     *
     * @return dict_sort - 排序
     */
    public Integer getDictSort() {
        return dictSort;
    }

    /**
     * 设置排序
     *
     * @param dictSort 排序
     */
    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    /**
     * 获取上级编号
     *
     * @return super_id - 上级编号
     */
    public Long getSuperId() {
        return superId;
    }

    /**
     * 设置上级编号
     *
     * @param superId 上级编号
     */
    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    /**
     * 获取备注
     *
     * @return dict_remark - 备注
     */
    public String getDictRemark() {
        return dictRemark;
    }

    /**
     * 设置备注
     *
     * @param dictRemark 备注
     */
    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }

    /**
     * 获取层级
     *
     * @return dict_level - 层级
     */
    public Integer getDictLevel() {
        return dictLevel;
    }

    /**
     * 设置层级
     *
     * @param dictLevel 层级
     */
    public void setDictLevel(Integer dictLevel) {
        this.dictLevel = dictLevel;
    }

    /**
     * 获取创建时间
     *
     * @return created_tm - 创建时间
     */
    public Date getCreatedTm() {
        return createdTm;
    }

    /**
     * 设置创建时间
     *
     * @param createdTm 创建时间
     */
    public void setCreatedTm(Date createdTm) {
        this.createdTm = createdTm;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取修改时间
     *
     * @return updated_tm - 修改时间
     */
    public Date getUpdatedTm() {
        return updatedTm;
    }

    /**
     * 设置修改时间
     *
     * @param updatedTm 修改时间
     */
    public void setUpdatedTm(Date updatedTm) {
        this.updatedTm = updatedTm;
    }

    /**
     * 获取修改人
     *
     * @return updated_by - 修改人
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置修改人
     *
     * @param updatedBy 修改人
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取是否有效：1.有效；2.无效
     *
     * @return is_enabled - 是否有效：1.有效；2.无效
     */
    public Byte getIsEnabled() {
        return isEnabled;
    }

    /**
     * 设置是否有效：1.有效；2.无效
     *
     * @param isEnabled 是否有效：1.有效；2.无效
     */
    public void setIsEnabled(Byte isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * 获取是否删除：1.未删除；2.已删除
     *
     * @return is_deleted - 是否删除：1.未删除；2.已删除
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除：1.未删除；2.已删除
     *
     * @param isDeleted 是否删除：1.未删除；2.已删除
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}