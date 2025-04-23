3D rendering engine written in java started on 9th of April, built from scratch with no external 3D libraries. I'm using a custom Rectangular class to generate a cube in my application to which I then apply a few changes

Features:

-scaling,rotation, translation using a custom Matrix4 class done somewhat efficiently (among other 4x4 matrix operations)

-support for chaining transformations via intuitive matrix multiplication 

-drawing in real time according to the camera's position

-checking for clipping using a zbuffer and rendering the pixels inside the triangles using barycentric coordonates

-basic camera movement with correct perspective transformation (WASDEQ for user input)

-a few other smaller things (ie a naive implementation of shading using the calculated barycentric coordonates, utils for interpolating and drawing lines etc, support for 3x3 matrix operations - meaning the object rendered is locked in place and not translate)

Concepts covered:

-3D to 2D screen mapping

-coordinate system transformations

-basic linear algebra in 3D graphics

-model -> world -> view -> projection 

-gouraud (and flat) shading

Features I hope to add in the future:

-better camera control (rotating the camera towards desired angle etc)

-phong shading, (and other types of shading)

-loading from external files

-interactive menu to change object attributes (ie position, size, or just setting changes ie adding an epsilon for precision calcuations)

-more custom classes for 3d objects (ie spheres)

![CubeExample](https://github.com/user-attachments/assets/4c058bba-f463-41da-bf76-2b8d36a31d87)
