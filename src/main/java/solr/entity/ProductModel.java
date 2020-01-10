package solr.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * 
 * @author Mancy
 * @version 1.0
 */
public class ProductModel implements Serializable {

    public static final String TABLE_NAME = "product";

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 别名
     */
    private String aliasName;

    /**
     * 默认图片
     */
    private String imageUrl;

    /**
     * 分类
     */
    private Long typeId;

    /**
     * 分类名称
     */
    private String typeName;

    /**
     * ID索引
     */
    private String typeIdpath;
    private String checkStatus;
    /**
     * 品牌
     */
    private Long brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 商家
     */
    private Long merchantId;

    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 价格
     */
    private Double price;


    /**
     * 商品编码
     */
    private String itemCode;

    /**
     * 商品单位
     */
    private Long unitId;

    /**
     * 商品单位名称
     */
    private String unitName;
    
    //有效期区间初始时间
    private String validStart;
    
    //有效期区间结束时间
    private String validEnd;
    
    //促销价
    private BigDecimal promotionPrice;
    
    //卖点
    private String activityTag;

    /**
     * 商品属性值 json格式
     * 
     * [{attrType:"Radio",isImage:false,attrId:1,name:"是否可定制",valId:2,value:"是"}
     * , {attrType:"Checkbox",isImage:false,attrId:2,name:"设计元素",values:[{valId:
     * 3,value:"做旧"},{valId:4,value:"手绘"},{valId:5,value:"雕花"}]},
     * {attrType:"Checkbox"
     * ,isImage:true,attrId:2,name:"空间",values:[{valId:3,value
     * :"客厅",img:""},{valId:4,value:"卧室",img:""}]},
     * {attrType:"Input",isImage:false,attrId:3,name:"包装体积",value:"1*1.5*2米"}]
     */
    private String attrJson;

    /**
     * 规格json
     * 
     * 格式： [{specId:1,isColor:true,name:"颜色分类",valId:2,value:"红色",colorCode:
     * "#ff0000",img:""}, {specId:2,isColor:false,name:"宽度",valId:3,value:"2米"},
     * {specId:1,isColor:false,name:"规格",valId:"_1_4",value:"123*45*67cm"}]
     */
    private String specValJson;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品规格介绍
     */
    private String specIntro;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 规格原价
     */
    private Double originalPrice;

    /**
     * 佣金总额
     */
    private BigDecimal commissionPrice = new BigDecimal(0);

    /**
     * 是否有+号
     */
    private boolean hasPlus = true;


    /**
     * 免邮券
     */
    private Long deliveryFreeId;

    /**
     * 排序值（仅用于品牌内部的商品排序）
     */
    private Integer orderValue;

    /**
     * 上架时间
     */
    private Date shelveTime;


    /**
     * 审核时间
     */
    private Date checkTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;

    /**
     * 删除标识
     */
    private boolean deleted;
    
    /**
     * 销量
     */
    private Double importPrice;

    //以下为福利社增加字段

    /**
     * 申报方案（此字段订单推送第e仓时需用到）
     */
    private String declarePlan;

    /**
     * 原产国
     */
    private String country;

    /**
     * 综合税率，2位小数（用于计算综合税）
     */
    private Double taxRate;


    /**
     * 结算主体
     */
    private Long settleBodyId;

    /**
     * 结算主体名称
     */
    private String settleBodyName;

    /**
     * 是否促销（默认值为否，此字段需生成到订单中，记录订单是否为促销订单）
     */
    private Boolean promoFlag = false;

    /**
     * 最小订购数
     */
    private Integer minBuyNum;

    /**
     * 最大购买数
     */
    private Integer maxBuyNum;

    /**
     * 是否使用卓志币
     * （此字段值为是时，该商品的购买金额可以使用卓志币进行抵用，只抵用此商品的商品总价）
     */
    private Boolean coinFlag;

    /**
     * 卓志币抵用最高比例，单位%（限制卓志币抵用商品总价的比例，默认为0）
     */
    private Integer coinPer = 0;

    /**
     * 是否单个结算
     */
    private Boolean singleFlag;

    /**
     * 商品成本，用户存第e仓同步过来的税前包邮价
     */
    private Double costPrice;

    /**
     * 商品利润，目前商品利润是在第e仓税前包邮件的基础上增加2%
     */
    private Double profitPrice;

    /**
     * 第e仓商品策略ID
     */
    private String strategyId;

    /**
     * 自提商品
     */
    private boolean selfSupport;

    /**
     * 销量
     */
    private Integer salesVolume;
    
    //7天内销量
    private Integer sevenBuyNum;
    
    
    /**
     * 返利比例
     */
    private BigDecimal rebateScale;

    /**
     * 渠道ID
     */
    private Long pfChannel;
    
    /**
     * 购买人数量
     */
    private Integer buyNum = 0;
    private Double rebatePrice;
    
    //跨境+下架标示 0未标示 1已标示（默认0）
    private Integer downSate;
    //平台下架标示 0未标示 1已标示（默认0）
    private Integer platformDownSate;
    //e仓下架标示 0未标示 1已标示（默认0）
    private Integer ewsDownSate;
    
    /**
     * 商品类型(1保税 2直邮)
     */
    private String itemType;
    
    private Long skuId;

    /**
     * 商城显示标题
     */
    private String showTitle;

	    /** 下架原因  */
    private String downReason;
    
    /**
     * 原始 成本价格
     */
    private Double originalCostPrice;
    /**
     * 库存
     */
    private Integer num;

    /**
     * 排序
     */
    private Double sort;

    public Double getSort() {
        return sort;
    }

    public void setSort(Double sort) {
        this.sort = sort;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    /**
     * 是否显示
     */
    private Boolean dispal;



	public Boolean getDispal() {
		return dispal;
	}

	public void setDispal(Boolean dispal) {
		this.dispal = dispal;
	}

	public Double getOriginalCostPrice() {
		return originalCostPrice;
	}

	public void setOriginalCostPrice(Double originalCostPrice) {
		this.originalCostPrice = originalCostPrice;
	}

	public String getDownReason() {
		return downReason;
	}

	public void setDownReason(String downReason) {
		this.downReason = downReason;
	}
     
    public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getProfitPrice() {
        return profitPrice;
    }

    public void setProfitPrice(Double profitPrice) {
        this.profitPrice = profitPrice;
    }

    public Double getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(Double importPrice) {
		this.importPrice = importPrice;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeIdpath() {
        return typeIdpath;
    }

    public void setTypeIdpath(String typeIdpath) {
        this.typeIdpath = typeIdpath;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getAttrJson() {
        return attrJson;
    }

    public void setAttrJson(String attrJson) {
        this.attrJson = attrJson;
    }

    public String getSpecValJson() {
        return specValJson;
    }

    public void setSpecValJson(String specValJson) {
        this.specValJson = specValJson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecIntro() {
        return specIntro;
    }

    public void setSpecIntro(String specIntro) {
        this.specIntro = specIntro;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getCommissionPrice() {
        return commissionPrice;
    }

    public void setCommissionPrice(BigDecimal commissionPrice) {
        this.commissionPrice = commissionPrice;
    }

    public boolean isHasPlus() {
        return hasPlus;
    }

    public void setHasPlus(boolean hasPlus) {
        this.hasPlus = hasPlus;
    }



    public Long getDeliveryFreeId() {
        return deliveryFreeId;
    }

    public void setDeliveryFreeId(Long deliveryFreeId) {
        this.deliveryFreeId = deliveryFreeId;
    }

    public Integer getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
    }

    public Date getShelveTime() {
        return shelveTime;
    }

    public void setShelveTime(Date shelveTime) {
        this.shelveTime = shelveTime;
    }



    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDeclarePlan() {
        return declarePlan;
    }

    public void setDeclarePlan(String declarePlan) {
        this.declarePlan = declarePlan;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }


    public Long getSettleBodyId() {
        return settleBodyId;
    }

    public void setSettleBodyId(Long settleBodyId) {
        this.settleBodyId = settleBodyId;
    }

    public String getSettleBodyName() {
        return settleBodyName;
    }

    public void setSettleBodyName(String settleBodyName) {
        this.settleBodyName = settleBodyName;
    }

    public Boolean getPromoFlag() {
        return promoFlag;
    }

    public void setPromoFlag(Boolean promoFlag) {
        this.promoFlag = promoFlag;
    }

    public Integer getMinBuyNum() {
        return minBuyNum;
    }

    public void setMinBuyNum(Integer minBuyNum) {
        this.minBuyNum = minBuyNum;
    }

    public Integer getMaxBuyNum() {
        return maxBuyNum;
    }

    public void setMaxBuyNum(Integer maxBuyNum) {
        this.maxBuyNum = maxBuyNum;
    }
    

    public String getValidStart() {
		return validStart;
	}

	public void setValidStart(String validStart) {
		this.validStart = validStart;
	}

	public String getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(String validEnd) {
		this.validEnd = validEnd;
	}

	public Boolean getCoinFlag() {
        return coinFlag;
    }

    public void setCoinFlag(Boolean coinFlag) {
        this.coinFlag = coinFlag;
    }

    public Integer getCoinPer() {
        return coinPer;
    }

    public void setCoinPer(Integer coinPer) {
        this.coinPer = coinPer;
    }

    public Boolean getSingleFlag() {
        return singleFlag;
    }

    public void setSingleFlag(Boolean singleFlag) {
        this.singleFlag = singleFlag;
    }
    

    public Integer getSevenBuyNum() {
		return sevenBuyNum;
	}

	public void setSevenBuyNum(Integer sevenBuyNum) {
		this.sevenBuyNum = sevenBuyNum;
	}

	public boolean getSelfSupport() {
        return selfSupport;
    }

    public void setSelfSupport(boolean selfSupport) {
        this.selfSupport = selfSupport;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Long getPfChannel() {
        return pfChannel;
    }

    public void setPfChannel(Long pfChannel) {
        this.pfChannel = pfChannel;
    }

    public BigDecimal getRebateScale() {
		return rebateScale;
	}

	public void setRebateScale(BigDecimal rebateScale) {
		this.rebateScale = rebateScale;
	}

    public Double getRebatePrice() {
        return rebatePrice;
    }

    public void setRebatePrice(Double rebatePrice) {
        this.rebatePrice = rebatePrice;
    }

    public BigDecimal getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public String getActivityTag() {
		return activityTag;
	}

	public void setActivityTag(String activityTag) {
		this.activityTag = activityTag;
	}
	

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	
	public Integer getDownSate() {
		return downSate;
	}

	public void setDownSate(Integer downSate) {
		this.downSate = downSate;
	}

	public Integer getPlatformDownSate() {
		return platformDownSate;
	}

	public void setPlatformDownSate(Integer platformDownSate) {
		this.platformDownSate = platformDownSate;
	}

	public Integer getEwsDownSate() {
		return ewsDownSate;
	}

	public void setEwsDownSate(Integer ewsDownSate) {
		this.ewsDownSate = ewsDownSate;
	}

    public String getShowTitle() {
        return showTitle;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
