package com.example.medicineapp.base

/**
 * Base Use Case class
 */
interface BaseUseCase<Params, Result> {
    suspend operator fun invoke(params: Params?): Result
}