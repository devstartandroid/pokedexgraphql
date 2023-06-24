package com.devstart.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import com.devstart.pokedex.R

@Composable
fun AppBackIconButton(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    imageVector: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back),
    onClick: () -> Unit = {}
) {
    IconButton(modifier = modifier, onClick = { onClick() }) {
        Image(
            imageVector = imageVector,
            contentDescription = null,
            colorFilter = ColorFilter.tint(color, BlendMode.SrcIn)
        )
    }
}