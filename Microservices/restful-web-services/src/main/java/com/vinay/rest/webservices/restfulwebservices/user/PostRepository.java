/**
 * 
 */
package com.vinay.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VINAY
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
