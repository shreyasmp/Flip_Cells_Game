package com.shreyasmp.blankproject.repository

import com.shreyasmp.blankproject.service.Service

interface Repository {

}

class RepositoryImpl(private val service: Service) : Repository {


}