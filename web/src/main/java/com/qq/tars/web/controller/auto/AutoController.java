package com.qq.tars.web.controller.auto;


import com.qq.tars.entity.ServerPatch;
import com.qq.tars.service.PatchService;
import com.qq.tars.service.SystemConfigService;
import com.qq.tars.service.task.AddTask;
import com.qq.tars.service.task.AddTaskItem;
import com.qq.tars.service.task.TaskResp;
import com.qq.tars.web.controller.TaskController;
import com.qq.tars.web.controller.auto.dto.AddDeployTaskReq;
import com.qq.tars.web.controller.auto.dto.AutoPatchReq;
import com.qq.tars.web.controller.auto.dto.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Date 2018/5/23      @Author Simba
 * @Description:
 */
@RestController
public class AutoController {
    private static final Logger logger = LoggerFactory.getLogger(AutoController.class);
    private static final int SYS_ERROR = 1;
    private static final String WAR_SUFFIX = ".war";
    @Autowired
    TaskController taskController;
    @Autowired
    private SystemConfigService systemConfigService;

    @Autowired
    private PatchService patchService;


    @RequestMapping(value = "auto/add_deploy_task")
    @ResponseBody
    public ResultDTO addDeployTask(AddDeployTaskReq addDeployTaskReq) {
        try {
            Map<String, String> map = new LinkedHashMap<>(3);
            map.put("patch_id", String.valueOf(addDeployTaskReq.getPatchId()));
            map.put("bak_flag", "false");
            map.put("update_text", addDeployTaskReq.getComment());

            AddTaskItem item = new AddTaskItem();
            item.setCommand("patch_tars");
            item.setServerId(addDeployTaskReq.getServerId());
            item.setParameters(map);

            AddTask addTask = new AddTask();
            addTask.setSerial(true);
            addTask.setItems(Arrays.asList(item));

            TaskResp taskResp = taskController.addTask(addTask);
            logger.info("execute addDeployTaskReq with addDeployTaskReq={},resp={}", addDeployTaskReq, taskResp);
            return new ResultDTO(taskResp.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("execute addDeployTaskReq occur an error with addDeployTaskReq={}", addDeployTaskReq, e);
            ResultDTO resultDTO = new ResultDTO();
            resultDTO.setResultCode(SYS_ERROR);
            resultDTO.setErrMsg(addDeployTaskReq.toString() + "     " + Arrays.toString(e.getStackTrace()));
            return resultDTO;
        }
    }

    @RequestMapping(value = "auto/add_patch")
    @ResponseBody
    public ResultDTO autoPatch(AutoPatchReq autoPatchReq) {
        try {
            String basePath = systemConfigService.getUploadTgzPath() + autoPatchReq.getApplication() + "/" + autoPatchReq.getModuleName() + "/";
            String artifactPath = basePath + autoPatchReq.getPatchName();
            if (autoPatchReq.getPatchName().endsWith(WAR_SUFFIX)) {
                artifactPath = patchService.war2tgz(artifactPath, autoPatchReq.getModuleName());
            }
            ServerPatch serverPatch = patchService.addServerPatch(autoPatchReq.getApplication(), autoPatchReq.getModuleName(), artifactPath, autoPatchReq.getComment());
            return new ResultDTO(serverPatch.getId());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("execute autoPatch occur an error with addDeployTaskReq={}", autoPatchReq, e);
            ResultDTO resultDTO = new ResultDTO();
            resultDTO.setResultCode(SYS_ERROR);
            resultDTO.setErrMsg(autoPatchReq.toString() + "     " + Arrays.toString(e.getStackTrace()));
            return resultDTO;
        }
    }
}
