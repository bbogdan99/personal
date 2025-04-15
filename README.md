3D rendering engine written in java started on 9th of April, built from scratch with no external 3D libraries. I'm using a custom

Rectangular class to generate a cube in my application to which I then apply a few changes

Features:

-scaling,rotation, translation using a custom Matrix4 class (among other 4x4 matrix operations)

-support for chaining transformations via intuitive matrix multiplication

-drawing in real time using sliders (ie to rotate the cube, change it's translation etc)

-checking for clipping using a zbuffer and rendering the pixels inside the triangles using barycentric coordonates

-a few other smaller things (ie a naive implementation of shading using the calculated barycentric coordonates, utils for 

interpolating and drawing lines etc, support for 3x3 matrix operations - meaning the object rendered is locked in place

and not translate)

Concepts covered:

-3D to 2D screen mapping

-coordinate system transformations

-basic linear algebra in 3D graphics

-model -> world -> view -> projection (which are not fully tackled yet)

Features I hope to add in the future:

-camera movement & control (rather than using the sliders present in the main code, defining a new custom

class and working with it in the project)

-lighting and (proper) shading

-loading from external files

-interactive menu to change object attributes (ie position, size, or just setting changes ie adding an epsilon for precision

calcuations)

-more custom classes for 3d objects (ie spheres)

![CubeExample](https://github.com/user-attachments/assets/4c058bba-f463-41da-bf76-2b8d36a31d87)
