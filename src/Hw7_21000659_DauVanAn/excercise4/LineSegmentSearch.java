package Hw7_21000659_DauVanAn.excercise4;

import java.util.ArrayList;
import java.util.List;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class LineSegment {
    Point start, end;

    public LineSegment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
}

class TreeNode {
    LineSegment lineSegment;
    TreeNode left, right;

    public TreeNode(LineSegment lineSegment) {
        this.lineSegment = lineSegment;
        this.left = null;
        this.right = null;
    }
}

public class LineSegmentSearch {

    private TreeNode root;

    public void insert(LineSegment lineSegment) {
        root = insert(root, lineSegment);
    }

    private TreeNode insert(TreeNode node, LineSegment lineSegment) {
        if (node == null) {
            return new TreeNode(lineSegment);
        }

        // Compare line segments based on their x-coordinates
        if (lineSegment.start.x < node.lineSegment.start.x) {
            node.left = insert(node.left, lineSegment);
        } else {
            node.right = insert(node.right, lineSegment);
        }

        return node;
    }

    public List<Point> findIntersections() {
        List<Point> intersections = new ArrayList<>();
        findIntersections(root, intersections);
        return intersections;
    }

    private void findIntersections(TreeNode node, List<Point> intersections) {
        if (node == null) {
            return;
        }

        // Check for intersections with the current line segment
        checkIntersections(root, node.lineSegment, intersections);

        // Recursively check left and right subtrees
        findIntersections(node.left, intersections);
        findIntersections(node.right, intersections);
    }

    private void checkIntersections(TreeNode node, LineSegment lineSegment, List<Point> intersections) {
        if (node == null) {
            return;
        }

        // Check for intersection between two line segments
        if (doIntersect(lineSegment.start, lineSegment.end, node.lineSegment.start, node.lineSegment.end)) {
            intersections.add(getIntersectionPoint(lineSegment.start, lineSegment.end, node.lineSegment.start, node.lineSegment.end));
        }

        // Recursively check left and right subtrees
        checkIntersections(node.left, lineSegment, intersections);
        checkIntersections(node.right, lineSegment, intersections);
    }

    private boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        return (o1 != o2 && o3 != o4);
    }

    private int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;
    }

    private Point getIntersectionPoint(Point p1, Point q1, Point p2, Point q2) {
        int a1 = q1.y - p1.y;
        int b1 = p1.x - q1.x;
        int c1 = a1 * p1.x + b1 * p1.y;

        int a2 = q2.y - p2.y;
        int b2 = p2.x - q2.x;
        int c2 = a2 * p2.x + b2 * p2.y;

        int determinant = a1 * b2 - a2 * b1;
        int x = (b2 * c1 - b1 * c2) / determinant;
        int y = (a1 * c2 - a2 * c1) / determinant;

        return new Point(x, y);
    }

    public static void main(String[] args) {
        LineSegmentSearch lineSegmentSearch = new LineSegmentSearch();

        // Add line segments to the tree
        lineSegmentSearch.insert(new LineSegment(new Point(1, 1), new Point(5, 1)));
        lineSegmentSearch.insert(new LineSegment(new Point(2, 0), new Point(2, 4)));
        lineSegmentSearch.insert(new LineSegment(new Point(3, 3), new Point(7, 3)));
        lineSegmentSearch.insert(new LineSegment(new Point(4, 2), new Point(4, 5)));
        lineSegmentSearch.insert(new LineSegment(new Point(0, 0), new Point(5, 0)));
        lineSegmentSearch.insert(new LineSegment(new Point(1, -1), new Point(1, 5)));
        lineSegmentSearch.insert(new LineSegment(new Point(4, 0), new Point(4, 5)));

        // Find intersections
        List<Point> intersections = lineSegmentSearch.findIntersections();

        // Print the intersections
        System.out.println("Intersection Points:");
        for (Point intersection : intersections) {
            System.out.println("(" + intersection.x + ", " + intersection.y + ")");
        }
    }
}

