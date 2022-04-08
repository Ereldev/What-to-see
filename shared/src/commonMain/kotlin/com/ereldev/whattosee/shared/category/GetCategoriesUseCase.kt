package com.ereldev.whattosee.shared.category

import com.ereldev.whattosee.shared.category.modelui.CategoryModelUI
import com.ereldev.whattosee.shared.category.modelui.CategoryTagUI

class GetCategoriesUseCase {

    suspend fun execute(): List<CategoryModelUI> {
        return listOf(
            CategoryModelUI(
                "MCU Movies & series",
                listOf(
                    CategoryTagUI(
                        "1234",
                        "mcu"
                    ),
                    CategoryTagUI(
                        "1234",
                        "marvel"
                    )
                )
            ),
            CategoryModelUI(
                "MCU Movies & series",
                listOf(
                    CategoryTagUI(
                        "1234",
                        "mcu"
                    ),
                    CategoryTagUI(
                        "1234",
                        "marvel"
                    )
                )
            )
        )
    }

}