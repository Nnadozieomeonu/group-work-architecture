package com.groupjn.authenticationservice.query

import com.groupjn.authenticationservice.entity.UserSummary
import com.groupjn.authenticationservice.model.User
import org.axonframework.commandhandling.model.Repository
import org.springframework.data.jpa.repository.JpaRepository

class GetProductsQuery

interface UserSummaryRepository: JpaRepository<UserSummary, String>
interface UserRpository: Repository<User>