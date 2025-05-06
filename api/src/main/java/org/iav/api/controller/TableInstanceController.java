package org.iav.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.iav.api.service.TableInstanceService;
import org.iav.model.entity.TableInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/table-instances")
@Slf4j
public class TableInstanceController {
    @Autowired
    private TableInstanceService tableInstanceService;

    /**
     * 根据 ID 获取 TableInstance 实例
     * @param id 实例 ID
     * @return TableInstance 实例
     */
    @GetMapping("/{id}")
    public ResponseEntity<TableInstance> getById(@PathVariable String id) {
        TableInstance tableInstance = tableInstanceService.getById(id);
        if (tableInstance != null) {
            return new ResponseEntity<>(tableInstance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 获取所有 TableInstance 实例
     * @return TableInstance 实例列表
     */
    @GetMapping
    public ResponseEntity<List<TableInstance>> getAll() {
        List<TableInstance> tableInstances = tableInstanceService.getAll();
        return new ResponseEntity<>(tableInstances, HttpStatus.OK);
    }

    /**
     * 保存 TableInstance 实例
     * @param tableInstance 要保存的实例
     * @return 保存结果
     */
    @PostMapping
    public ResponseEntity<Boolean> saveTableInstance(@RequestBody TableInstance tableInstance) {
        boolean result = tableInstanceService.saveTableInstance(tableInstance);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * 根据 ID 删除 TableInstance 实例
     * @param id 实例 ID
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        boolean result = tableInstanceService.deleteById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 更新 TableInstance 实例
     * @param tableInstance 要更新的实例
     * @return 更新结果
     */
    @PutMapping
    public ResponseEntity<Boolean> updateTableInstance(@RequestBody TableInstance tableInstance) {
        boolean result = tableInstanceService.updateTableInstance(tableInstance);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
