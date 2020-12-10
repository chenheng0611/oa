package com.xray.oa.service.impl;

import com.xray.oa.entity.Job;
import com.xray.oa.mapper.JobMapper;
import com.xray.oa.service.IJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xray
 * @since 2020-12-08
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements IJobService {

}
