package org.iav.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.iav.model.entity.TableInstance;

import java.util.List;

public interface TableInstanceService extends IService<TableInstance> {
    /**
     * 根据 ID 获取 TableInstance 实例
     * @param id 实例 ID
     * @return TableInstance 实例
     */
    TableInstance getById(String id);

    /**
     * 获取所有 TableInstance 实例
     * @return TableInstance 实例列表
     */
    List<TableInstance> getAll();

    /**
     * 保存 TableInstance 实例
     * @param tableInstance 要保存的实例
     * @return 是否保存成功
     */
    boolean saveTableInstance(TableInstance tableInstance);

    /**
     * 根据 ID 删除 TableInstance 实例
     * @param id 实例 ID
     * @return 是否删除成功
     */
    boolean deleteById(String id);

    /**
     * 更新 TableInstance 实例
     * @param tableInstance 要更新的实例
     * @return 是否更新成功
     */
    boolean updateTableInstance(TableInstance tableInstance);
}