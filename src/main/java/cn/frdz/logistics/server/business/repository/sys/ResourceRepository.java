package cn.frdz.logistics.server.business.repository.sys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.frdz.logistics.server.business.entity.sys.Resource;

public interface ResourceRepository extends JpaRepository<Resource, String>,JpaSpecificationExecutor<Resource>{

}
