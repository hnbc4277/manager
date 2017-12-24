package cn.frdz.logistics.server.business.repository.sys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.frdz.logistics.server.business.entity.sys.User;

public interface UserRepository extends JpaRepository<User, String>,JpaSpecificationExecutor<User>{

	 User findByUsername(String username);
}
