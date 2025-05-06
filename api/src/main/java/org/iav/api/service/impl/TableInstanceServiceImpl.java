package org.iav.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.iav.api.mapper.TableInstanceMapper;
import org.iav.api.service.TableInstanceService;
import org.iav.model.entity.TableInstance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableInstanceServiceImpl extends ServiceImpl<TableInstanceMapper, TableInstance> implements TableInstanceService {
    @Override
    public TableInstance getById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<TableInstance> getAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public boolean saveTableInstance(TableInstance tableInstance) {
        return save(tableInstance);
    }

    @Override
    public boolean deleteById(String id) {
        return removeById(id);
    }

    @Override
    public boolean updateTableInstance(TableInstance tableInstance) {
        return updateById(tableInstance);
    }
}