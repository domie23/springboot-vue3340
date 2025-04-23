package com.dao;

import com.entity.KaoqinguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoqinguanliView;

/**
 * 院系考勤管理 Dao 接口
 *
 * @author 
 */
public interface KaoqinguanliDao extends BaseMapper<KaoqinguanliEntity> {

   List<KaoqinguanliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
