package com.yidiandian.controller;

import com.yidiandian.entity.BatchEntity;
import com.yidiandian.request_view.BatchView;
import com.yidiandian.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/26 18:19
 * @Email: 15290810931@163.com
 */
@RestController
public class BatchController {

    @Autowired
    BatchService batchService;
    /**
     * 批量增加
     */
    @PostMapping("/batchInsert")
    @ResponseBody
    public ResponseEntity<BatchEntity> batchInsert(@RequestBody List<BatchEntity> entityList){
        batchService.batchInsert(entityList);
        return new ResponseEntity("保存成功", HttpStatus.OK);
    }
    /**
     * 批量增加
     */
    @PostMapping("/batchInsertForUpdate")
    @ResponseBody
    public ResponseEntity<BatchEntity> batchInsertForUpdate(@RequestBody List<BatchEntity> entityList){
        batchService.batchInsertForUpdate(entityList);
        return new ResponseEntity("保存成功", HttpStatus.OK);
    }

    /**
     * 删除
     */
    @DeleteMapping("/deleteList")
    @ResponseBody
    public ResponseEntity<BatchEntity> deleteList(@RequestParam("list") List<Integer> idList){
        batchService.deleteList(idList);
        return new ResponseEntity("删除成功", HttpStatus.OK);
    }

    /**
     * 删除
     */
    @DeleteMapping("/deleteArray")
    @ResponseBody
    public ResponseEntity<BatchEntity> deleteArray(Integer[] ids){
        batchService.deleteArray(ids);
        return new ResponseEntity("删除成功", HttpStatus.OK);
    }
    /**
     * 修改
     */
    @PutMapping("/batchUpdate")
    @ResponseBody
    public ResponseEntity<BatchEntity> batchUpdate(@RequestBody List<BatchEntity> entityList){
        batchService.batchUpdate(entityList);
        return new ResponseEntity("修改成功", HttpStatus.OK);
    }

    /**
     * 修改
     */
    @PutMapping("/updates")
    @ResponseBody
    public ResponseEntity<BatchEntity> updates(@RequestBody List<BatchEntity> entityList){
        batchService.updates(entityList);
        return new ResponseEntity("修改成功", HttpStatus.OK);
    }


    /**
     * 查询
     */
    @PostMapping("/findList")
    public ResponseEntity<BatchEntity> findList(@RequestBody List<BatchEntity> entityList){
        return new ResponseEntity(batchService.findList(entityList),HttpStatus.OK);
    }

    /**
     * 根据ids 进行查询
     * @param batchView
     * @return
     */
    @PostMapping("/findByIds")
    public ResponseEntity<BatchEntity> findByIds(@RequestBody BatchView batchView){
        return new ResponseEntity(batchService.findByIds(batchView.getIdArray()),HttpStatus.OK);
    }
}
